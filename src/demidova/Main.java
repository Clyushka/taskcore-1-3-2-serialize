package demidova;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //int health, int weapons, int lvl, double distance
        List<GameProgress> gp = new ArrayList(){{
                add(new GameProgress(10, 5, 3, 34.5));
                add(new GameProgress(100, 29, 15, 105.9));
                add(new GameProgress(200, 100, 76, 1046.98));
        }};

        File savegamesDir = new File("Games\\savegames");

        for (int i = 0; i < gp.size(); i++) {
            File saveDat = new File(savegamesDir, "save" + i + ".dat");

            try {
                saveDat.createNewFile();
                FileOutputStream fos = new FileOutputStream(saveDat);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(gp.get(i));
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                System.exit(0);
            }
        }
    }
}
