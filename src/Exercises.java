import java.util.ArrayList;

public class Exercises {

  public int findMe(int[] list, int target) {
    if (list == null) {
      return -1;
  }

  for (int i = 0; i < list.length; i++) {
      if (list[i] == target) {
          return i;
      }
  }

    return -1;
  }

  public int findMe(ArrayList<String> list, String target) {
    if (list == null) {
      return -1;
   }

    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).equals(target)) {
            return i;
        }
    }
    
    return -1;
  }

  public int findMeFaster(ArrayList<Integer> list, int target) {
    if (list == null) {
      return -1;
    }

    int lower = 0;
    int mid = 0;
    int upper = list.size();


    while (lower <= upper) {
      mid = (upper + lower) / 2;

      if (target > list.get(mid)) {
          lower = mid + 1;
      } else if (target < list.get(mid)) {
          upper = mid - 1;
      } else {
          return mid;
      }
   }
    
    return -1;
    }

  public int findMeFaster(String[] list, String target) {
    if (list == null || target.equals(null)) {
      return -1;
    }

    int lower = 0;
    int upper = list.length;
    int mid = 0;

    while (lower <= upper) {
        mid = (lower + upper) / 2;

        if (0 > list[mid].compareTo(target)) {
            lower = mid + 1;
        } else if (0 < list[mid].compareTo(target)) {
            upper = mid - 1;
        } else if (list[mid].equals(target)) {
            return mid;
        }
    }
      
      return -1;
  }

  public int[] bubble(int[] list, boolean ascending) {
    if (list == null) {
      return null;
    }

    Boolean sorted = false;

    while (!sorted) {
        sorted = true;

        for (int i = 0; i < list.length - 1; i++) {
            if (ascending) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    sorted = false;
                }
            } else {
                if (list[i] < list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }
    return list;
  }

  public ArrayList<String> bubble(ArrayList<String> list, boolean ascending) {
    if (list == null) {
      return null;
    }

    Boolean sorted = false;

    while (!sorted) {
        sorted = true;

        for (int i = 0; i < list.size() - 1; i++) {
            if (ascending) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    String temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            } else {
                if (list.get(i).compareTo(list.get(i + 1)) < 0) {
                    String temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
    }
    return list;
  }

  public ArrayList<Integer> insertion(ArrayList<Integer> list, boolean ascending) {
    if (list == null) {
      return null;
    }

    for (int i = 1; i < list.size(); i++) {
        for (int j = i; j > 0; j--) {
            if (ascending && list.get(j - 1) > list.get(j)) {
                int temp = list.get(j - 1);
                list.set(j - 1, list.get(j));
                list.set(j, temp);
            } else if (list.get(j - 1) < list.get(j) && !ascending) {
                int temp = list.get(j - 1);
                list.set(j - 1, list.get(j));
                list.set(j, temp);
            }
        }
    }
    return list;
  }

  public String[] insertion(String[] list, boolean ascending) {
    if (list == null) {
      return null;
    }

    for (int i = 1; i < list.length; i++) {
      
        for (int j = i; j > 0; j--) {
            if (ascending && 0 > list[j].compareTo(list[j - 1])) {
                String temp = list[j - 1];
                list[j - 1] = list[j];
                list[j] = temp;
            } else if (0 < list[j].compareTo(list[j - 1]) && !ascending) {
                String temp = list[j - 1];
                list[j - 1] = list[j];
                list[j] = temp;
            }
        }
    }
    return list;
  }

  public int[] selection(int[] list, boolean ascending) {
    if (list == null) {
      return null;
    }

    for (int i = 0; i < list.length; i++) {
        int targetIndex = i;
        for (int j = i + 1; j < list.length; j++) {
            if (list[j] < list[targetIndex] && ascending) {
                targetIndex = j;
            } else if (list[j] > list[targetIndex] && !ascending) {
                targetIndex = j;
            }
        }

        if (targetIndex != i) {
            int temp = list[i];
            list[i] = list[targetIndex];
            list[targetIndex] = temp;
        }
    }
    return list;
  }

  public ArrayList<String> selection(ArrayList<String> list, boolean ascending) {
    if (list == null) {
      return null;
    }

    for (int i = 0; i < list.size(); i++) {
        int targetIndex = i;
        for (int j = i + 1; j < list.size(); j++) {
            if (0 > list.get(j).compareTo(list.get(targetIndex)) && ascending) {
                targetIndex = j;
            } else if (0 < list.get(j).compareTo(list.get(targetIndex)) && !ascending) {
                targetIndex = j;
            }
        }

        if (targetIndex != i) {
            String temp = list.get(i);
            list.set(i, list.get(targetIndex));
            list.set(targetIndex, temp);
        }
    }
    return list;
  }

  public ArrayList<Integer> merge(ArrayList<Integer> list, boolean ascending) {
    if (list == null || list.size() < 1) {
      return null;
    }

    if (list.size() == 1) {
        return list;
    }


    ArrayList <Integer> right = new ArrayList <Integer> ();
    ArrayList <Integer> left = new ArrayList <Integer> ();
    for (int i = 0; i < list.size() / 2; i++) {
        left.add(list.get(i));
    }

    for (int i = list.size() / 2; i < list.size(); i++) {
        right.add(list.get(i));
    }
    right = merge(right, ascending);
    left = merge(left, ascending);

    ArrayList <Integer> sortedList = new ArrayList <Integer> ();
    while (right.size() != 0 && left.size() != 0) {
        if (ascending) {
            if (right.get(0) < left.get(0)) {
                sortedList.add(right.get(0));
                right.remove(0);
            } else {
                sortedList.add(left.get(0));
                left.remove(0);
            }
        } else {
            if (right.get(0) > left.get(0)) {
                sortedList.add(right.get(0));
                right.remove(0);
            } else {
                sortedList.add(left.get(0));
                left.remove(0);
            }
        }
    }
    if (right.size() > 0) {
        sortedList.addAll(right);
    } else if (left.size() > 0) {
        sortedList.addAll(left);
    }

    return sortedList;
  }

  public String[] merge(String[] list, boolean ascending) {
    if (list == null || list.length < 1) {
      return null;
    }


    if (list.length > 1) {
        String[] right = new String[list.length - list.length / 2];
        String[] left = new String[list.length / 2];
        for (int i = 0; i < left.length; i++) {

            left[i] = list[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = list[i + list.length / 2];
        }
        merge(right, ascending);

        merge(left, ascending);

        int l = 0;
        int r = 0;

        for (int i = 0; i < list.length; i++) {
            if (ascending) {
                if (r >= right.length || (l < left.length && left[l].compareTo(right[r]) < 0)) {
                    list[i] = left[l];
                    l++;
                } else {
                    list[i] = right[r];
                    r++;
                }
            } else {
                if (r >= right.length || (l < left.length && left[l].compareTo(right[r]) > 0)) {
                    list[i] = left[l];
                    l++;
                } else {
                    list[i] = right[r];
                    r++;
                }

            }
        }
    }
    return list;
  }
}