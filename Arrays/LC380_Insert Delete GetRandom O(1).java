/*
Problem: 380. Insert Delete GetRandom O(1)
Platform: LeetCode
Difficulty: Medium

Approach:
- Use an ArrayList to store the elements for O(1) random access.
- Use a HashMap to store each element and its index in the ArrayList.
- Insert:
  - If the element already exists, return false.
  - Otherwise, add it to the ArrayList and store its index in the HashMap.
- Remove:
  - If the element does not exist, return false.
  - Swap the element to be removed with the last element in the ArrayList.
  - Update the last element's index in the HashMap.
  - Remove the last element from the ArrayList and delete the entry from the HashMap.
- getRandom:
  - Generate a random index and return the element at that index.
- Swapping with the last element ensures O(1) removal without shifting elements.

Time Complexity:
- insert(): O(1) average
- remove(): O(1) average
- getRandom(): O(1)

Space Complexity: O(n)
*/

import java.util.*;

class RandomizedSet {

    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        list.set(index, lastElement);
        map.put(lastElement, index);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
