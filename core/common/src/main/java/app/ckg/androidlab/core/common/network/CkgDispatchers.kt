package app.ckg.androidlab.core.common.network

import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * 왜 굳이 기본적으로 제공되는 [Dispatchers.IO], [Dispatchers.Default] 등을 사용하지 않고
 * DI를 통해 커스텀 Dispatcher와 CoroutineScope를 제공할까?
 *
 * 주된 이유는 테스트 용이성으로 보인다.
 * - 기존 코틀린 디스패처를 그대로 쓰면 테스트를 할 때도 [Dispatchers.IO], [Dispatchers.Default]가 그대로 쓰이므로,
 *   실제 I/O 스레드에서 돌아가게 된다. 이는 테스트를 동기적으로 수행하기 어렵게 만들고, 타이밍 이슈나 예측 불가능한 결과가 발생할 수 있다.
 *
 * - 주입받도록 만들어 두면 DI 컨테이너(Hilt) 를 통해 제공되는 CoroutineDispatcher를 테스트용 디스패처(UnconfinedTestDispatcher)로 교체하여 테스트할 수 있다.
 *   이렇게 하면 메인 스레드 혹은 동기적 디스패처에서 동작시키며, 테스트 결과를 예측하기가 훨씬 쉬워진다.
 *
 * 즉, Dispatcher를 주입 가능하게 만들어 두면, 앱 로직에서 스레드나 코루틴 실행 환경이 하드코딩되지 않으므로, Mock 또는 Test Dispatcher로 손쉽게 갈아끼울 수 있다.
 */
@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val ckgDispatchers: CkgDispatchers)

enum class CkgDispatchers {
    Default,
    IO,
}