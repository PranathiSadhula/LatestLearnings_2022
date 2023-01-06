package datastructures.interviewready;



public class ComparableTest implements Comparable<ComparableTest> {

    int empId;
    String empName;

    @Override
    public int compareTo(ComparableTest o) {
        if(this.empId == o.empId && this.empName.equals(o.empName)) return 1;
        return 0;
    }
}
