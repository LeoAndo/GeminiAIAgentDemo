package jp.ac.jec.cm0199.geminiaiagentdemo.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import jp.ac.jec.cm0199.geminiaiagentdemo.data.Robot
import jp.ac.jec.cm0199.geminiaiagentdemo.viewmodel.RobotViewModel

@Composable
fun RobotListScreen(
    robotViewModel: RobotViewModel = viewModel(),
    innerPadding: PaddingValues,
    onItemClick: (Robot) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        LazyColumn(modifier = Modifier.padding(8.dp)) {
            items(
                items = robotViewModel.robots,
                key = { robot -> robot.id }
            ) { robot ->
                RobotListItem(robot = robot) {
                    onItemClick(it)
                }
            }
        }
        FloatingActionButton(
            onClick = { robotViewModel.updateRobot() },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(imageVector = Icons.Default.Refresh, contentDescription = "更新")
        }
    }
}

@Composable
fun RobotListItem(robot: Robot, onClick: (Robot) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick(robot) }
    ) {
        Text(
            text = robot.name,
            modifier = Modifier.padding(16.dp)
        )
    }
}
