package io.github.xyzboom.oneoktodo.model

import io.github.xyzboom.oneoktodo.model.tasks.TaskExecutionMode

class ExecutionModeConfig(
    val mode: TaskExecutionMode,
    val scheduledConfig: ScheduledConfig,
    val quantitativeConfig: QuantitativeConfig
) {
    class ScheduledConfig(
        val deadline: String,
        val reminder: String
    )

    class QuantitativeConfig(
        val target: Int,
        val current: Int,
        val timeUnit: String
    )
}