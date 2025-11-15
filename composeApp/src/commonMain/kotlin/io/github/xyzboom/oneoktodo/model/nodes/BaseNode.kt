package io.github.xyzboom.oneoktodo.model.nodes

class BaseNode(
    val id: String,
    val prevs: MutableSet<String>,
    val succs: MutableSet<String>,
) {

}