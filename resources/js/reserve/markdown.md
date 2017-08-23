#자바스크립트와 이벤트 루프  
> 단일 스레드 기반의 언어이다 한번에 하나의 언어만 처리 가능하다   
> 실제로는 동시에 처리하는 것처럼 보인다. 바로 이벤트루프 이용하여 동시성을 지원한다.  
><a href="https://www.youtube.com/watch?v=6MXRNXXgP_0">관련 영상 </a>

##Javascript engine  
> Rendering engine: HTML, CSS와 같은 마크 관련 코드를 웹페이지에 rendering해주는 역할  
> Javascript engine: Javascript코드를 해석하고 실행하는 인터프린터  

최근에는 자바스크립트 엔진으로 V8과 같은 엔진을 이용한다  

자바스크립트의 3가지 영역
* Call Stack
* Task(Event) Queue
* Heap  
* Event Loop(V8 한정) : Task Queue에 들어가는 Task를 관리  

#### Call Stack



 