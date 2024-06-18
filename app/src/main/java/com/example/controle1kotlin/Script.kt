package com.example.controle1kotlin

class Velo(var marque:String,var modele:String,var prix:Double,var quantiteStock:Int,var id:String){

    override fun toString(): String {
        return "Velo(marque='$marque' ,modele='$modele' ,prix=$prix ,quantiteStock=$quantiteStock ,id='$id')"
    }
    fun provisionner(quantiteEntree:Int){
        quantiteStock+=quantiteEntree
        println("La nouvelle quantité a été bien ajoutée dans le stock avec succès !")
    }
    fun sortir(quatiteSortie:Int):String{
        var msg:String=""
        if (quatiteSortie <= quantiteStock){
            quantiteStock-=quatiteSortie
            msg="Il ne reste que ${quantiteStock} vélo dont la marque ${marque}"
        }else{
            msg="La quantité demandée a dépassé celle du stock !"
        }
        return msg
    }
    fun estDisponible():Boolean {
        return quantiteStock > 0
    }
}
class Client(var nom:String,var pannier:ArrayList<Velo>,var quantiteAchette:ArrayList<Int>,var isLoyal:Boolean){

    override fun toString(): String {
        return "Client(nom='$nom', pannier=$pannier, quantiteAchette=$quantiteAchette, isLoyal=$isLoyal)"
    }
    fun addToCart(velo:Velo,quantiteDesiree:Int){
        if (quantiteDesiree <= velo.quantiteStock){
            pannier.add(velo)
            quantiteAchette.add(quantiteDesiree)
            velo.quantiteStock-=quantiteDesiree
            println("La quantité de vélo désiré à acheter a été bien ajoutées dans le pannier !" +
                    "\n"+"Et bien il reste ${velo.quantiteStock} vélo dont la marque est ${velo.marque}")
        }else{
            println("La quantité de vélo désiré à acheter a dépassé celle du stock !")
        }
    }
    fun delFromCart(idVelo:String):String{
        var msg:String=""
        for (i in 0 until pannier.size){
            if (pannier[i].id.equals(idVelo)){
                pannier[i].quantiteStock+=quantiteAchette[i]
                pannier.remove(pannier[i])
                quantiteAchette.remove(quantiteAchette[i])
                msg="Le vélo dont l'id ${idVelo} a été bien supprimé !"
                break
            }else{
                msg="La référence du vélo que vous avez saisi ${idVelo} n'est pas trouvée dans le pannier !"
            }
        }
        return msg
    }
    fun clearCart(){
        pannier.clear()
        quantiteAchette.clear()
        println("Les deux panniers sont vides !")
    }
    fun calculerTotalPannier():Double{
        var total:Double=0.0
        for (i in 0 until pannier.size){
            total+=(pannier[i].prix*quantiteAchette[i])
        }
        if (isLoyal && total>1300.0){
            total*=0.9
        }
        return total
    }
}

fun main() {
    val velo1=Velo("Decathlon","xt-205",5199.0,10,"DecXt205")
    val velo2=Velo("BMX","sv-1999",3100.0,5,"BmxSV1999")
    val velo3=Velo("Corsa","c-2022",6000.0,7,"corsaXt22")
    var stockVelo=ArrayList<Velo>()
    stockVelo.add(velo1)
    stockVelo.add(velo2)
    stockVelo.add(velo3)
    println(stockVelo)
/**********************************************************************************************/
    val client1=Client("Hassan", arrayListOf(), arrayListOf(),true)
    /**************************************************************************************************/
    velo1.provisionner(3)
    println(velo1.quantiteStock)
    velo2.provisionner(4)
    println(velo2.quantiteStock)
    velo3.provisionner(2)
    println(velo3.quantiteStock)
/*****************************************************************************************************/
    println(velo1.estDisponible())
    if (velo1.estDisponible()){
        println("Ce vélo ${velo1.marque} est disponible !")
    }else{
        println("Ce vélo ${velo1.marque} n'est pas disponible !")
    }
    println(velo2.estDisponible())
    if (velo2.estDisponible()){
        println("Ce vélo ${velo2.marque} est disponible !")
    }else{
        println("Ce vélo ${velo2.marque} n'est pas disponible !")
    }
    println(velo3.estDisponible())
    if (velo3.estDisponible()){
        println("Ce vélo ${velo3.marque} est disponible !")
    }else{
        println("Ce vélo ${velo3.marque} n'est pas disponible !")
    }
/********************************************************************************/
    println(velo1.sortir(10))
    println(velo2.sortir(9))
    println(velo3.sortir(14))
/**************************************************************************************/
    println(velo1.estDisponible())
    if (velo1.estDisponible()){
        println("Ce vélo ${velo1.marque} est disponible !")
    }else{
        println("Ce vélo ${velo1.marque} n'est pas disponible !")
    }
    println(velo2.estDisponible())
    if (velo2.estDisponible()){
        println("Ce vélo ${velo2.marque} est disponible !")
    }else{
        println("Ce vélo ${velo2.marque} n'est pas disponible !")
    }
    println(velo3.estDisponible())
    if (velo3.estDisponible()){
        println("Ce vélo ${velo3.marque} est disponible !")
    }else{
        println("Ce vélo ${velo3.marque} n'est pas disponible !")
    }
/**********************************************************************************/
    velo2.provisionner(4)
    println(velo2.quantiteStock)
    println(velo2.estDisponible())
    if (velo2.estDisponible()){
        println("Ce vélo ${velo2.marque} est disponible !")
    }else{
        println("Ce vélo ${velo2.marque} n'est pas disponible !")
    }
/****************************************************************************************/
    println(velo1.quantiteStock)
    println(velo2.quantiteStock)
    println(velo3.quantiteStock)
/******************************************************************************************/
    client1.addToCart(velo1,2)
    client1.addToCart(velo2,2)
    client1.addToCart(velo3,10)
    println(client1.quantiteAchette)
    println(client1.pannier)
    println(stockVelo)
    println(velo1.quantiteStock)
    println(velo2.quantiteStock)
    println(velo3.quantiteStock)
 /**********************************************************************************************/
    println("Le total est ${client1.calculerTotalPannier()} dh")
 /*********************************************************************************************/
    client1.clearCart()
    println(client1.pannier)
    println(client1.quantiteAchette)
    println(velo1.quantiteStock)
    println(velo2.quantiteStock)
    println(velo3.quantiteStock)
    println(stockVelo)
 /*****************************************************************************************/
    client1.addToCart(velo1,2)
    client1.addToCart(velo2,2)
    client1.addToCart(velo3,2)
    println(client1.pannier)
    println(client1.quantiteAchette)
    println(velo1.quantiteStock)
    println(velo2.quantiteStock)
    println(velo3.quantiteStock)
    println(stockVelo)
 /**************************************************************************************/
    println("Le total est ${client1.calculerTotalPannier()} dh")
 /********************************************************************/
    println(client1.delFromCart("BmxSV1998"))
    println(stockVelo)
    println(client1.delFromCart("BmxSV1999"))
    println(client1.pannier)
    println(client1.quantiteAchette)
    println(stockVelo)
}
