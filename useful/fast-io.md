# fast io

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

int N = Integer.parseInt(br.readLine());
int array[] = new int[N];

StingTokenizer st = new StringTokenizer(br.readLine());
for(int i = 0; i < N; i++){
    array[i] = Integer.parseInt(st.nextToken());
}

for(int i = 0; i < N; i++){
    bw.write(String.valueOf(array[i]));
    bw.write("\n");
}

bw.flush();
bw.close();
```

