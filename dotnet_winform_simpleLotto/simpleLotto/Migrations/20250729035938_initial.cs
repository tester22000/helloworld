using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace simpleLotto.Migrations
{
    /// <inheritdoc />
    public partial class initial : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "lottoDrawResults",
                columns: table => new
                {
                    drwNo = table.Column<int>(type: "INTEGER", nullable: false)
                        .Annotation("Sqlite:Autoincrement", true),
                    returnValue = table.Column<string>(type: "TEXT", nullable: false),
                    drwNoDate = table.Column<string>(type: "TEXT", nullable: false),
                    totSellamnt = table.Column<long>(type: "INTEGER", nullable: false),
                    firstWinamnt = table.Column<long>(type: "INTEGER", nullable: false),
                    firstPrzwnerCo = table.Column<int>(type: "INTEGER", nullable: false),
                    firstAccumamnt = table.Column<long>(type: "INTEGER", nullable: false),
                    drwtNo1 = table.Column<int>(type: "INTEGER", nullable: false),
                    drwtNo2 = table.Column<int>(type: "INTEGER", nullable: false),
                    drwtNo3 = table.Column<int>(type: "INTEGER", nullable: false),
                    drwtNo4 = table.Column<int>(type: "INTEGER", nullable: false),
                    drwtNo5 = table.Column<int>(type: "INTEGER", nullable: false),
                    drwtNo6 = table.Column<int>(type: "INTEGER", nullable: false),
                    bnusNo = table.Column<int>(type: "INTEGER", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_lottoDrawResults", x => x.drwNo);
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "lottoDrawResults");
        }
    }
}
