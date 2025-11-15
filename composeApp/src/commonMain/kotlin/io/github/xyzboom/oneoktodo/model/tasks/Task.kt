package io.github.xyzboom.oneoktodo.model.tasks

import kotlinx.datetime.LocalDate

data class Task(
    val name: String,
    val description: String? = null,
    val endDate: LocalDate? = null,
    // todo add other properties
)