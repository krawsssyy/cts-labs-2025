import Memento.*;
import Template_Method.*;

public class Main {
    public static void main(String[] args) {
        // memento
        Hero hero = new Hero();
        hero.move(1, 1);
        CheckpointStack checkpoints = new CheckpointStack();
        checkpoints.addCheckpoint(hero.saveState());
        hero.takeDamage(10);
        System.out.println("Hero health before restore: " + hero.getHealth());
        hero.loadState(checkpoints.restoreCheckpoint());
        System.out.println("Hero health after restore: " + hero.getHealth());

        // for template method, everything is relatively self explanatory
        AbstractReportGenerator generator = new HtmlReportGenerator();
        System.out.println(generator.generateReport("Test webpage", "sample data", "CTS footer"));

        // generally, testing is handled by the build system, and not ran manually by us
    }
}
