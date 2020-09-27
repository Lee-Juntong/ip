package duke.exception;

public class DeleteUndefinedTaskException extends DeleteException {
    private String label="";//Task label of the task
    public DeleteUndefinedTaskException(){};
    public DeleteUndefinedTaskException(String label){
        this.label=label;
    }
    public String getMessage(){
       return "☹ OOPS!!! There isn't a task labeled "+label;
    }
}
