public class Main {
    public static void main(String[] args) {
        HomeTheatreFacade system = new HomeTheatreFacade();
        system.watchMovie("Oppenheimer");
        system.endMovie();
        system.listenMusic();
        system.endMusic();
    }
}
