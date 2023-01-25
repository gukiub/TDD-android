package gustavo.video_solution.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.br.gustavo.outsideintdd.utils.MainCoroutineScopeRule
import org.junit.Rule

open class BaseUnitTest {

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

}