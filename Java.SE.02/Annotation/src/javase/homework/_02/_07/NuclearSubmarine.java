package javase.homework._02._07;

/**
 * Created by Yana on 19.10.2015.
 */

@Annotation(
        author = "Yana Guseva",
        date = "19.10.2015",
        lastModified = "19.10.2015"
)
public class NuclearSubmarine {
    private EngineForNuclearSubmarine engine;

    NuclearSubmarine() {
        engine = new EngineForNuclearSubmarine();
    }

    class EngineForNuclearSubmarine {
        public void startMotor() {
            System.out.println("The engine is turned on");
        }
    }

    public void startToSwim() {
        engine.startMotor();
        System.out.println("Started swimming");
    }
}
