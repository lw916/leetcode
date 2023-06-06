class Solution {

    int[] _jobs;
    int _k;
    int jobs_length;
    int result = 0x3f3f3f3f;

    public int minimumTimeRequired(int[] jobs, int k) {
        _jobs = jobs;
        _k = k;
        jobs_length = jobs.length;
        int[] jobForWorker = new int[k]; // 工作分配情况(工作量), 第n位工人分配的工作为jobForWorker[n]
        dfs(0, 0 ,jobForWorker, 0);
        return result;
    }

    // used 为未安排工作的工人, 为他们先安排工作, 默认从第一位工人即0开始安排工作
    void dfs(int n, int used, int[] jobForWorker, int max){
        if(max >= result) return;
        if(n == jobs_length) {
            result = max;
            return;
        }
        // 优先分配给有空闲的人干活
        if(used < _k){
            jobForWorker[used] = _jobs[n];
            dfs(n+1, used + 1, jobForWorker, Math.max(jobForWorker[used], max));
            jobForWorker[used] = 0;
        }
        // k个人的第一份工作安排完毕， 开始安排下一份工作
        for(int i = 0; i < used; i++){
            jobForWorker[i] += _jobs[n];
            dfs(n+1, used, jobForWorker, Math.max(jobForWorker[i], max));
            jobForWorker[i] -= _jobs[n];
        }
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int[] jobs = new int[]{3,2,3};
        System.out.println(S.minimumTimeRequired(jobs, 3));
    }
}