package duke.exception;

public class WrongCommandException extends InvalidCommandException {
    public String getMessage(){
        return "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";
    }
}
