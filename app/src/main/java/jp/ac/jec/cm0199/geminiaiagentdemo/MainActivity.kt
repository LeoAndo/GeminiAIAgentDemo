package jp.ac.jec.cm0199.geminiaiagentdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import jp.ac.jec.cm0199.geminiaiagentdemo.ui.screen.RobotListScreen
import jp.ac.jec.cm0199.geminiaiagentdemo.ui.theme.GeminiAIAgentDemoTheme
import jp.ac.jec.cm0199.geminiaiagentdemo.viewmodel.RobotViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val robotViewModel: RobotViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeminiAIAgentDemoTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
                ) { innerPadding ->
                    RobotListScreen(
                        robotViewModel = robotViewModel,
                        innerPadding = innerPadding,
                        onItemClick = { robot ->
                            scope.launch {
                                snackbarHostState.showSnackbar("${robot.name}がクリックされました")
                            }
                        }
                    )
                }
            }
        }
    }
}
