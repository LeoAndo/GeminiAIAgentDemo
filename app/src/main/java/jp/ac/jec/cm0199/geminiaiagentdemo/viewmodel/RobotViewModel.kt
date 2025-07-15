package jp.ac.jec.cm0199.geminiaiagentdemo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import jp.ac.jec.cm0199.geminiaiagentdemo.data.Robot

class RobotViewModel : ViewModel() {
    var robots by mutableStateOf<List<Robot>>(emptyList())
        private set

    init {
        loadRobots()
    }

    private fun loadRobots() {
        robots = (1..10).map { Robot(id = it, name = "ロボット${it}号") }
    }

    fun updateRobot() {
        robots = robots.map { robot ->
            if (robot.id % 2 == 0) {
                robot.copy(name = "ロボット${(100..999).random()}号")
            } else {
                robot
            }
        }
    }
}