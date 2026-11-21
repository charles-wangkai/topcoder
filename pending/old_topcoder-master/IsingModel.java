
public class IsingModel {

    public int energy(String[] spins) {
        int totalEnergy = 0;
        for (int i = 0; i < spins.length; i++) {
            for (int j = 0; j < spins[0].length(); j++) {
                char spin = spins[i].charAt(j);
                if (i >= 1) {
                    totalEnergy += getEnergy(spin, spins[i - 1].charAt(j));
                }
                if (j >= 1) {
                    totalEnergy += getEnergy(spin, spins[i].charAt(j - 1));
                }
            }
        }
        return totalEnergy;
    }

    int getEnergy(char spin1, char spin2) {
        if (spin1 == spin2) {
            return -1;
        } else {
            return 1;
        }
    }
}
