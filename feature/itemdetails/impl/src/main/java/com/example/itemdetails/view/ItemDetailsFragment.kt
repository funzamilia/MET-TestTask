package com.example.itemdetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.itemdetails.view.compose.ItemDetailsScreen
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.withCreationCallback

private const val ARGUMENT_ITEM_ID = "itemId"

@AndroidEntryPoint
class ItemDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val itemId = arguments?.getString(ARGUMENT_ITEM_ID)
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val viewModel: ItemDetailsViewModel by viewModels(
                    extrasProducer = {
                        defaultViewModelCreationExtras.withCreationCallback<ItemDetailsViewModel.Factory> {
                            it.create(itemId)
                        }
                    }
                )
                ItemDetailsScreen(viewModel)
            }
        }
    }
}