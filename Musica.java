import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
//@Setter
@RequiredArgsConstructor

public class Musica {
  private int codigo;
  private final String titulo;
  private final int avaliacao;

  @Override
  public String toString() {
    // return "A música se chama: " + titulo + ". A sua nota é " + avaliacao;
    return String.format(
      "A música se chama %s. A sua nota é %d.",
      titulo, avaliacao
    );
  }
}
