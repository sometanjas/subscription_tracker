package com.hwr.subscriptiontracker.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AddSubscriptionViewModel : ViewModel() {

    var name by mutableStateOf("")
    var price by mutableStateOf("")
    var paymentCycle by mutableStateOf("Monthly")
    var category by mutableStateOf("")
    var billingDate by mutableStateOf("")
    var link by mutableStateOf("")
    var relatedServices by mutableStateOf("")

    var errorMessage by mutableStateOf("")
    var isSaved by mutableStateOf(false)
    var isLoading by mutableStateOf(false)

    fun resetForm() {
        name = ""
        price = ""
        paymentCycle = "Monthly"
        category = ""
        billingDate = ""
        link = ""
        relatedServices = ""
    }

    fun saveSubscription() {
        errorMessage = ""

        if (name.isBlank()) {
            errorMessage = "Please enter a name."
            return
        }

        if (price.isBlank()) {
            errorMessage = "Please enter a price."
            return
        }

        val priceAsDouble = price.toDoubleOrNull()
        if (priceAsDouble == null) {
            errorMessage = "Please enter a valid number for price."
            return
        }

        val userId = FirebaseAuth.getInstance().currentUser?.uid

        if (userId == null) {
            errorMessage = "You must be logged in."
            return
        }

        isLoading = true

        val data = hashMapOf(
            "name" to name.trim(),
            "price" to priceAsDouble,
            "paymentCycle" to paymentCycle,
            "category" to category.trim(),
            "billingDate" to billingDate,
            "link" to link.trim(),
            "relatedServices" to relatedServices.trim(),
            "userId" to userId
        )

        FirebaseFirestore.getInstance()
            .collection("subscriptions")
            .add(data)
            .addOnSuccessListener {
                isLoading = false
                isSaved = true
                resetForm()
            }
            .addOnFailureListener { exception ->
                isLoading = false
                errorMessage = exception.localizedMessage ?: "Failed to save."
            }
    }
}