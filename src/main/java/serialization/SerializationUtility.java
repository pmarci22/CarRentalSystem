package serialization;

import model.Model;

import java.io.*;

public class SerializationUtility {
    public static void serializeModel(Model model, String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(model);
        }
    }

    public static Model deserializeModel(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (Model) in.readObject();
        }
    }
}
