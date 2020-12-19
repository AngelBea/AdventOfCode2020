package angelbea.advents

import angelbea.*
import angelbea.interfaces.IAdventCodes
import org.w3c.dom.traversal.TreeWalker
import javax.swing.JTree
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.DefaultTreeModel
import javax.swing.tree.TreeModel

class Day7_HandyHaversacks : IAdventCodes {
    override val nameOfChallenge: String
        get() = javaClass.simpleName
    override var input: MutableList<String> = ScannerTool().readFileFromDisk(INPUT_FILE_7)

    override fun start() {
        val bagList = input.map { "(\\w* ){2}".toRegex().find(it) }.map { Bag(it!!.value.trim()) }
        val bagsWithQuantity = bagList.map { bag ->
            val rule = input.filter { it.startsWith(bag.name) }[0]
            val quantities = "\\d+ (\\w+ ){2}".toRegex().findAll(rule).toMutableList().map { it.value }
            quantities.forEach {
                bag.bags.add(
                    BagQuantity(
                        bagList.find { bagFromList ->
                            bagFromList.name.equals(
                                "( \\w+){2}$".toRegex().find(it.trim())?.value?.trim()
                            )
                        }!!,
                        "\\d+".toRegex().find(it)!!.value.toInt()
                    )
                )
            }
            bag
        }

        val bagsWithEventuallyShiny = bagsWithQuantity.filter { bag ->
            bag.bags.any { it.bag.isShinyGoldBag() } || bag.hasInDeepShinyGoldBag()
        }

        println("The number of bags that will eventually contain a Shiny Gold Bag is -> ${bagsWithEventuallyShiny.count()}")

        val shinyBagChildren = mutableListOf<BagQuantity>()

        val shinyGoldBag = bagsWithQuantity.filter { it.name == SHINY_GOLD_BAG_NAME }.first()
    }


    fun Bag.isShinyGoldBag(): Boolean {
        return this.name == SHINY_GOLD_BAG_NAME
    }

    fun Bag.hasInDeepShinyGoldBag(): Boolean {
        this.bags.forEach { bagDeep1 ->
            if (bagDeep1.bag.isShinyGoldBag()) {
                return true
            }
            if (bagDeep1.bag.bags.isNotEmpty()) {
                bagDeep1.bag.bags.forEach { bagDeep2 ->
                    if (bagDeep2.bag.isShinyGoldBag()) {
                        return true
                    }
                    if (bagDeep2.bag.bags.isNotEmpty()) {
                        bagDeep2.bag.bags.forEach { bagDeep3 ->
                            if (bagDeep3.bag.isShinyGoldBag()) {
                                return true
                            }
                            if (bagDeep3.bag.bags.isNotEmpty()) {
                                bagDeep3.bag.bags.forEach { bagDeep4 ->
                                    if (bagDeep4.bag.isShinyGoldBag()) {
                                        return true
                                    }
                                    if (bagDeep4.bag.bags.isNotEmpty()) {
                                        bagDeep4.bag.bags.forEach { bagDeep5 ->
                                            if (bagDeep5.bag.isShinyGoldBag()) {
                                                return true
                                            }
                                            if (bagDeep5.bag.bags.isNotEmpty()) {
                                                bagDeep5.bag.bags.forEach { bagDeep6 ->
                                                    if (bagDeep6.bag.isShinyGoldBag()) {
                                                        return true
                                                    }
                                                    if (bagDeep6.bag.bags.isNotEmpty()) {
                                                        bagDeep6.bag.bags.forEach { bagDeep7 ->
                                                            if (bagDeep7.bag.isShinyGoldBag()) {
                                                                return true
                                                            }
                                                            if (bagDeep7.bag.bags.isNotEmpty()) {
                                                                bagDeep7.bag.bags.forEach { bagDeep8 ->
                                                                    if (bagDeep8.bag.isShinyGoldBag()) {
                                                                        return true
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false
    }

    data class BagQuantity(val bag: Bag, val quantity: Int)
    data class Bag(val name: String, val bags: MutableList<BagQuantity>) {
        constructor(name: String) : this(name, mutableListOf())
    }


}