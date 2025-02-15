package packModelo.Fichas;

public abstract class Ficha {
      private int pos;

      public abstract String getTipo();

      protected Ficha(){
      }

      public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Ficha other = (Ficha) obj;
            // Comparar los tipos de las fichas
            return this.getTipo().equals(other.getTipo());
      }

      public int getPos(){
            return this.pos;
      }

      public void setPos(int pPos){
            this.pos = pPos;
      }
} 
