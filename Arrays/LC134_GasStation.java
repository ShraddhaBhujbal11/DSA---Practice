/*
Problem: 134. Gas Station
Platform: LeetCode
Difficulty: Medium

Approach:
- Traverse all gas stations while maintaining two variables:
  - totalGas: Overall gas remaining after completing the entire circuit.
  - currentGas: Gas remaining while traveling from the current starting station.
- For each station, calculate the net gas gained:
  - gas[i] - cost[i]
- Add the net gas to both totalGas and currentGas.
- If currentGas becomes negative, the current starting station cannot complete the circuit.
  - Reset currentGas to 0.
  - Set the next station as the new starting point.
- After traversing all stations:
  - If totalGas is negative, completing the circuit is impossible, so return -1.
  - Otherwise, return the computed starting index.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currentGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int netGas = gas[i] - cost[i];

            totalGas += netGas;
            currentGas += netGas;

            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }

        return totalGas >= 0 ? start : -1;
    }
}
