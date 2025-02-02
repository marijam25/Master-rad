package Datafly;

import DataTables.Student;
import DomainGeneralizationHierarchy.DGH;

import java.util.*;

public class Anonymize {

    public static void dataflyAnonymize(int k, ArrayList<String> quasiIdentifiers, ArrayList<Student> studentList, HashMap<String, DGH> dghList) {
        boolean isKAnonymous = false;

        while (!isKAnonymous) {
            Map<ArrayList<String>, Integer> groupCounts = countGroups(studentList, quasiIdentifiers);
            isKAnonymous = checkKAnonymity(groupCounts, k);

            if (isKAnonymous) break;

            String attributeToGeneralize = findAttributeToGeneralize(studentList, quasiIdentifiers);

            if (attributeToGeneralize != null) {
                generalizeAttribute(studentList, attributeToGeneralize, dghList.get(attributeToGeneralize));
            }
        }
    }

    private static Map<ArrayList<String>, Integer> countGroups(ArrayList<Student> studentList, ArrayList<String> quasiIdentifiers) {
        Map<ArrayList<String>, Integer> groupCounts = new TreeMap<>((a, b) -> compareArrayLists(a,b));
        for (Student s : studentList) {
            ArrayList<String> quasiIdentifierValues = s.getQuasiIdentifierValues(quasiIdentifiers);
            if(groupCounts.containsKey(quasiIdentifierValues)) {
                int oldValue = groupCounts.get(quasiIdentifierValues);
                groupCounts.remove(quasiIdentifierValues);
                groupCounts.put(quasiIdentifierValues,oldValue+1);
            } else{
                groupCounts.put(quasiIdentifierValues,1);
            }
        }
        return groupCounts;
    }

    private static int compareArrayLists(ArrayList<String> a, ArrayList<String> b) {
        int minSize = Math.min(a.size(), b.size());
            for (int i = 0; i < minSize; i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }

        return Integer.compare(a.size(), b.size());
    }

    private static boolean checkKAnonymity(Map<ArrayList<String>, Integer> groupCounts, int k) {
        for (int count : groupCounts.values()) {
            if (count < k) {
                return false;
            }
        }
        return true;
    }

    private static String findAttributeToGeneralize(ArrayList<Student> studentList, ArrayList<String> quasiIdentifiers) {
        String bestAttribute = null;
        int maxDistinctValues = 0;
        HashMap<String, HashSet<String>> uniqueValues = new HashMap<>();

        for (String attr : quasiIdentifiers) {
            uniqueValues.put(attr, new HashSet<>());
        }

        for (Student s : studentList) {
            for (String qi : quasiIdentifiers) {
                uniqueValues.get(qi).add(s.getAttributeValue(qi));
            }
        }

        for (String qi : quasiIdentifiers) {
            int distinctCount = uniqueValues.get(qi).size();
            if (distinctCount > maxDistinctValues) {
                maxDistinctValues = distinctCount;
                bestAttribute = qi;
            }
        }

        return bestAttribute;
    }

    private static void generalizeAttribute(ArrayList<Student> studentList, String attribute, DGH dgh) {
        for (Student s : studentList) {
            String oldValue = s.getAttributeValue(attribute);
            String newValue = dgh.generalise(oldValue);
            s.setAttributeValue(attribute, newValue);
        }
    }
}
