package org.example.exercice1;

class NombreNegatifException extends RuntimeException {
    private int valeurErronee;

    public NombreNegatifException(String message, int valeurErronee) {
        super(message);
        this.valeurErronee = valeurErronee;
    }

    public int getValeurErronee() {
        return valeurErronee;
    }
}

class EntierNaturel {
    private int val;

    public EntierNaturel(int val) throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException("La valeur ne peut pas être négative", val);
        }
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException("La valeur ne peut pas être négative", val);
        }
        this.val = val;
    }

    public void decrementer() throws NombreNegatifException {
        if (val == 0) {
            throw new NombreNegatifException("La valeur est déjà à zéro", val);
        }
        val--;
    }
}

 class TestEntierNaturel {
    public static void main(String[] args) {
        try {
            EntierNaturel entier = new EntierNaturel(-5);
        } catch (NombreNegatifException e) {
            System.out.println("Erreur: " + e.getMessage());
            System.out.println("Valeur erronée: " + e.getValeurErronee());
        }

        try {
            EntierNaturel entier = new EntierNaturel(10);
            entier.setVal(-3);
        } catch (NombreNegatifException e) {
            System.out.println("Erreur: " + e.getMessage());
            System.out.println("Valeur erronée: " + e.getValeurErronee());
        }

        try {
            EntierNaturel entier = new EntierNaturel(0);
            entier.decrementer();
        } catch (NombreNegatifException e) {
            System.out.println("Erreur: " + e.getMessage());
            System.out.println("Valeur erronée: " + e.getValeurErronee());
        }
    }
}
