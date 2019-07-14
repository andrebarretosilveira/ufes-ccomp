using System.Collections.Generic;
using UnityEngine;

public class PoolManager : MonoBehaviour
{
    public static PoolManager instance;

    [Space]

    public List<PoolObject> PoolObjects;
    public Transform PoolObjsParent;

    private Dictionary<GameObject, List<GameObject>> Pool;


    private void Awake()
    {
        if (instance == null) { instance = this; }
        else { Destroy(this.gameObject); }

        Pool = new Dictionary<GameObject, List<GameObject>>();
    }

    private void OnEnable()
    {
        Init();
    }

    public void Init()
    {
        foreach (var poolObj in PoolObjects)
        {
            CreateClones(poolObj.Prefab, poolObj.CloneAmount);
        }
    }

    private void CreateClones(GameObject prefab, int amountOfClones)
    {
        if (Pool.ContainsKey(prefab))
        {
            Debug.LogError("[PoolManager] Pool already contain clones for " +
                "the prefab (" + prefab.name + ")");

            return;
        }

        var gameObjs = new List<GameObject>();

        for (int i = 0; i < amountOfClones; i++)
        {
            var clone = Instantiate(prefab, Vector3.zero, Quaternion.identity, PoolObjsParent);
            clone.SetActive(false);
            gameObjs.Add(clone);
        }

        Pool[prefab] = gameObjs;

        //Debug.Log("[PoolManager] Created pool for (" + prefab.name + ") " +
        //    "with (" + amountOfClones + ") clones");
    }

    public GameObject GetClone(GameObject prefab, bool canExpand = false)
    {
        if (!Pool.ContainsKey(prefab))
        {
            Debug.LogError("[PoolManager] Pool does not contain " +
                "the prefab (" + prefab + ")");

            return null;
        }

        foreach (var go in Pool[prefab])
        {
            if (!go.activeInHierarchy)
            {
                go.transform.SetParent(PoolObjsParent);
                go.transform.SetPositionAndRotation(Vector3.zero, Quaternion.identity);

                return go;
            }
        }

        // No objects available to retrieve. Grow pool?
        if (canExpand)
        {
            //Debug.Log("[PoolManager] Growing pool for object (" + prefab.name + ").");

            var go = Instantiate(prefab, Vector3.zero, Quaternion.identity, PoolObjsParent);
            go.SetActive(false);
            Pool[prefab].Add(go);

            return go;
        }

        // No objects to retrieve and can't grow pool...
        Debug.LogWarning("[PoolManager] All objects of type " +
            "(" + prefab.name + ") are currently in use");

        return null;
    }

    public void Clear()
    {
        foreach (var value in Pool.Values)
        {
            foreach (var clone in value)
            {
                Destroy(clone);
            }
        }

        Pool.Clear();
    }

    [System.Serializable]
    public class PoolObject
    {
        public GameObject Prefab;
        public int CloneAmount;
    }
}