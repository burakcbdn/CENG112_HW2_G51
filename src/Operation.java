//Class for making operating easier

public class Operation {

    private String operator;
    private String operation;

    public Operation(String opr , String opn) {
        operator = opr;
        operation = opn;
    }

    public String getOperation() {
        return operation;
    }

    public String getOperator() {
        return operator;
    }
}
