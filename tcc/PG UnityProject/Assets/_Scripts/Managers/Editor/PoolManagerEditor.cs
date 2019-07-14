using UnityEditor;
using UnityEngine;

[CustomEditor(typeof(PoolManager))]
public class PoolManagerEditor : Editor
{
    public override void OnInspectorGUI()
    {
        // Grab the script.
        PoolManager Target = target as PoolManager;

        // Set the indentLevel to 0 as default (no indent).
        EditorGUI.indentLevel = 0;

        // Update
        serializedObject.Update();

        GUI.enabled = false;
        EditorGUILayout.ObjectField("Script",
            MonoScript.FromMonoBehaviour(Target), typeof(PoolManager), false);
        GUI.enabled = true;

        EditorGUILayout.BeginHorizontal();

        EditorGUILayout.BeginVertical();

        //  >>> THIS PART RENDERS THE ARRAY
        SerializedProperty poolObjsProp = this.serializedObject.FindProperty("PoolObjects");
        SerializedProperty cloneParentProp = this.serializedObject.FindProperty("PoolObjsParent");

        EditorGUILayout.Space();
        EditorGUILayout.Space();

        EditorGUILayout.PropertyField(cloneParentProp);

        EditorGUILayout.Space();

        EditorGUILayout.BeginHorizontal();

        EditorGUILayout.LabelField("Pool Objs Size");
        EditorGUILayout.PropertyField(poolObjsProp.FindPropertyRelative("Array.size"), GUIContent.none);

        EditorGUILayout.EndHorizontal();

        EditorGUILayout.Space();

        for (int i = 0; i < poolObjsProp.arraySize; i++)
        {
            EditorGUILayout.Space();

            SerializedProperty elemProp = poolObjsProp.GetArrayElementAtIndex(i);
            SerializedProperty gameObjProp = elemProp.FindPropertyRelative("Prefab");
            SerializedProperty cloneAmountProp = elemProp.FindPropertyRelative("CloneAmount");

            EditorGUILayout.BeginHorizontal();

            EditorGUILayout.PropertyField(gameObjProp, GUIContent.none, GUILayout.MinWidth(120));
            EditorGUILayout.PropertyField(cloneAmountProp, GUIContent.none, GUILayout.MaxWidth(30));

            if (GUILayout.Button("Remove", EditorStyles.miniButton))
            {
                Target.PoolObjects.RemoveAt(i);
            }

            EditorGUILayout.EndHorizontal();
        }
        //  >>>

        EditorGUILayout.EndVertical();

        EditorGUILayout.EndHorizontal();

        EditorGUILayout.Separator();
        EditorGUILayout.Space();

        if (GUILayout.Button("Add Pool Object", EditorStyles.miniButton))
        {
            Target.PoolObjects.Add(null);
        }

        EditorGUILayout.Space();
        EditorGUILayout.Space();

        // Apply.
        serializedObject.ApplyModifiedProperties();
    }
}