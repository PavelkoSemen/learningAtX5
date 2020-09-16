import ru.x5.computer.Computer;
import ru.x5.computer.ComputerFacade;

public class Main {

    public static void main(String[] args) {
        Computer baseComputer = new ComputerFacade().baseComputer();
        baseComputer.computerInfo();
    }
}
