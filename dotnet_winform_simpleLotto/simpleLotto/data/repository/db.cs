using Microsoft.EntityFrameworkCore;
using simpleLotto.data.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace simpleLotto.data.repository {
    internal sealed class DB : DbContext {
        private static readonly DB instance = new DB();
        public DbSet<LottoDrawResult> lottoDrawResults { get; set; }

        private readonly string _dbPath;

        public DB() {
            _dbPath = Path.Combine(Environment.CurrentDirectory, "lotto.sqlite.db");
        }

        public static DB Instance { get { return instance; } } 

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder) {
            optionsBuilder.UseSqlite($"Data Source={_dbPath}");
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder) {
            base.OnModelCreating(modelBuilder);
        }

    }
}
