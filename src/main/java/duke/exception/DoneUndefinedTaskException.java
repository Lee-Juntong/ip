package duke.exception;

public class DoneUndefinedTaskException extends DoneException {
    private String label="";//Task label of the task
    public DoneUndefinedTaskException(){};
    public DoneUndefinedTaskException(String label){
        this.label=label;
    }
    public String getMessage(){
        return "☹ OOPS!!! There isn't a task labeled "+label;
    }
}
