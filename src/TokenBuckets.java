public class TokenBuckets implements Runnable{

    private int tokenBucketC = Main.cbs;
    private int tokenBucketE = Main.ebs;

    @Override
    public void run() {
        while (true){
            update();
            try {
                Thread.sleep((long) (1 / Main.cir) * Main.THOUSAND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update(){
      if(tokenBucketC < Main.cbs){
        tokenBucketC++;
      }else if(tokenBucketE < Main.ebs){
        tokenBucketE++;
      }
    }

    int getTokenBucketC() {
        return tokenBucketC;
    }

    int getTokenBucketE() {
        return tokenBucketE;
    }

    void setTokenBucketC(int tokenBucketC) {
        this.tokenBucketC = tokenBucketC;
    }

    void setTokenBucketE(int tokenBucketE) {
        this.tokenBucketE = tokenBucketE;
    }
}
