
	public class MagicNum {

		public MagicNum() {
			this.iterations=0;
			this.isMagic=false;

		}

		private int iterations;
		private boolean isMagic;

		public boolean isMagic() {
			return isMagic;
		}

		public void setMagic(boolean isMagic) {
			this.isMagic = isMagic;
		}

		public int getIterations() {
			return iterations;
		}

		public void setIterations(int iterations) {
			this.iterations = iterations;
		}

	}
