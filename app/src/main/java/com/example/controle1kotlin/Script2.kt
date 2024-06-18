package com.example.controle1kotlin

open class Produit(private var nom:String,private var prix:Double){
    override fun toString(): String {
        return "Produit(nom='$nom', prix=$prix)"
    }
    fun getNom():String{
        return nom
    }
    fun setNom(nom:String){
        this.nom=nom
    }
    fun getPrix():Double{
        return prix
    }
    fun setPrix(prix:Double){
        this.prix=prix
    }
}
class ProduitAchete(nom: String,prix: Double,private var quantite:Int):Produit(nom,prix){
    override fun toString(): String {
        return "ProduitAchete(nom='${this.getNom()}', prix=${this.getPrix()} ,quantite=$quantite)"
    }
    fun getQuantite():Int{
        return quantite
    }
    fun setQuantite(quantite: Int){
        this.quantite=quantite
    }
}
class Customer(private var cin:String,private var pannier:ArrayList<ProduitAchete>){
    override fun toString(): String {
        return "Client(cin='$cin' ,pannier=$pannier)"
    }
    fun getCin():String{
        return cin
    }
    fun setCin(cin:String){
        this.cin=cin
    }
    fun getPannier():ArrayList<ProduitAchete> {
        return pannier
    }
    fun setPannier(pannier:ArrayList<ProduitAchete>){
        this.pannier=pannier
    }
    fun acheter(pa:ProduitAchete){
        pannier.add(pa)
    }
    fun calculerTotal():Double{
        var total:Double=0.0
        for (pa in pannier){
            total+=pa.getPrix()*pa.getQuantite()
        }
        return total
    }
}
fun main() {
    val pr = Produit("Samsung G1", 3750.0)
    println(pr)
    val pa = ProduitAchete("LG 530", 4300.0, 4)
    println(pa)
    val c1 = Customer("QA34567", arrayListOf())
    println(c1)
    c1.acheter(pa)
    val pa2 = ProduitAchete("HP S12", 3200.0, 2)
    c1.acheter(pa2)
    println(c1.calculerTotal())
    println(c1.getCin())
    println(c1.getPannier())

}