/*
/
/ + ------------- + ------------------------------- + ---------------------------------------- +
/ | NPM           | Nama Anggota                    |  Role's Of Members                       |
/ | ------------- + ------------------------------- + ---------------------------------------- +
/ | 2108107010075 | Muhammad Firdaus                |  Role : Leader, Code Maker               |
/ | 2108107010089 | Habil Nasution                  |  Role : Desainer, Bug Fixer              |
/ | 2108107010082 | Sharahiya                       |  Role : Game Guide, Explainer Code       |
/ | 2108107010079 | Riyan Farhan Ramadhan           |  Role : FlowChart Maker, Bug Fixer       |
/ | 2108107010097 | Afifah Nibras                   |  Role : Explainer Code, FlowChart Maker  |
/ + ------------- + ------------------------------- + ---------------------------------------- +
/
*/

public class Logic {
  // Jumlah tiles yang ada pada game
  private int nbTiles;
  // Tiles memiliki nilai index unique
  private int[] tiles;

  public Logic() {
  }

  // Hanya setengah permutasi puzzle yang dapat diselesaikan
  // Ketika sebuah tile diikuti tile yang melebihi nomernya, maka akan
  // dihitung sebagai inversi. Jika blankTile berada di posisi seharusnya,
  // jumlah inversi haruslah genap agar puzzle dapat diselesaikan
  public boolean isSolvable(PuzzleGrid pg) {
    this.tiles = pg.getTiles();
    nbTiles = tiles.length - 1;
    int countInversion = 0;

    for (int i = 0; i < nbTiles; i++) {
      for (int j = 0; j < i; j++) {
        if (tiles[j] > tiles[i])
          countInversion++;
      }
    }
    return countInversion % 2 == 0;
  }

  // Method yang memeriksa apakah semua tiles berada di posisi seharusnya agar
  // game selesai
  public boolean isSolved(int tiles[]) {
    this.tiles = tiles;
    // jika blankPos belum ada di posisi terakhir maka belum selesai
    if (tiles[tiles.length - 1] != 0)
      return false;

    for (int i = tiles.length - 2; i >= 0; i--) {
      if (tiles[i] != i + 1)
        return false;
    }
    return true;
  }
}
