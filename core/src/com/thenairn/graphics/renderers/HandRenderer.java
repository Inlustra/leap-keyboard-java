/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.graphics.renderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.particles.ParticleSystem;
import com.badlogic.gdx.graphics.g3d.particles.batches.PointSpriteParticleBatch;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.leapmotion.leap.Bone.Type;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.HandList;
import com.leapmotion.leap.Vector;
import com.thenairn.graphics.CustomGraphicsEnvironment;
import com.thenairn.leap.misc.GraphicsToLeap;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Tom
 */
public class HandRenderer {

    private ModelBatch modelBatch;
    private Map<Type, Model[]> models;
    private Map<Type, ModelInstance[]> bones;

    public HandRenderer() {
        modelBatch = new ModelBatch();
        models = new EnumMap<Type, Model[]>(Type.class);
        bones = new EnumMap<Type, ModelInstance[]>(Type.class);
        for (Type type : Type.values()) {
            models.put(type, new Model[5]);
            bones.put(type, new ModelInstance[5]);
        }
    }

    public void render(CustomGraphicsEnvironment env, Frame frame) {
                
        modelBatch.begin(env.getCamera());
        HandList hList = frame.hands();

        for (int i = 0; i < hList.count(); i++) {
            Hand hand = hList.get(i);
            Vector handXBasis = hand.palmNormal().cross(hand.direction()).normalized();
            Vector handYBasis = hand.palmNormal().opposite();
            Vector handZBasis = hand.direction().opposite();
            Vector handOrigin = hand.palmPosition();

            FingerList fList = hand.fingers();
            for (int j = 0; j < fList.count(); j++) {
                Finger finger = fList.get(j);
                for (Type type : Type.values()) {
                    ModelInstance modelI = getBone(type, j);
                    Vector leapPos = finger.bone(type).center();
                    if (type == Type.TYPE_DISTAL) {
                        leapPos = finger.stabilizedTipPosition();
                    }
                    Vector3 pos = GraphicsToLeap.leapToVector3(leapPos);
                    modelI.transform.setToTranslation(pos);
                    modelBatch.render(modelI, env.getEnvironment());
                }
            }
        }

        modelBatch.end();
    }

    public ModelInstance getBone(Type type, int i) {
        return bones.get(type)[i] == null ? createBone(type, i) : bones.get(type)[i];
    }

    private ModelInstance createBone(Type type, int i) {
        ModelBuilder modelBuilder = new ModelBuilder();
        Material mat = new Material(ColorAttribute.createDiffuse(Color.GREEN));
        Vector size = new Vector(10f, 10f, 10f);
        switch (type) {

            case TYPE_DISTAL:
                mat = new Material(ColorAttribute.createDiffuse(Color.RED));
                break;
        }
        Model model = modelBuilder.createSphere(size.getX(), size.getY(), size.getZ(), 10, 10,
                mat,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        models.get(type)[i] = model;
        ModelInstance minstance = new ModelInstance(model);
        bones.get(type)[i] = minstance;
        return minstance;
    }
}
