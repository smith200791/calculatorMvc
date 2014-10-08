import intf.Operation;
import intf.Viewer;
import factory.OperationFactory;
import factory.ViewerFactory;

/**
 * @author macbookretina
 * 
 */
public class Calculate {

    public Double result;



    public void executeOperation(String code,Double... args) {
        OperationFactory operationFactory = new OperationFactory();
        Operation operation = operationFactory.createOperation(code);
        result = operation.operate(args[0],args[1]);

    }

    public void viewLastResult(String viewCode) {
        ViewerFactory viewerFactory = new ViewerFactory();
        Viewer viewer = viewerFactory.createView(viewCode);
        viewer.onView(result);
    }

    public void ssumm(double d, double e) {
        result = d + e;
        
    }

}
