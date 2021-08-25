package ru.oliverhd.kudagoevents.categorieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.oliverhd.kudagoevents.databinding.FragmentCategoriesListBinding
import ru.oliverhd.kudagoevents.main.App
import ru.oliverhd.kudagoevents.repository.EventCategory
import ru.oliverhd.kudagoevents.repository.Repository
import javax.inject.Inject

class CategoriesListFragment : MvpAppCompatFragment(), CategoriesListView,
    CategoriesListAdapter.Delegate {

    @Inject
    lateinit var repository: Repository

    private val categoriesListAdapter = CategoriesListAdapter(delegate = this)

    @Inject
    lateinit var router: Router

    private val presenter: CategoriesListPresenter by moxyPresenter {
        CategoriesListPresenter(repository, router)
    }

    private var binding: FragmentCategoriesListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentCategoriesListBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.categoriesListRecyclerView?.adapter = categoriesListAdapter
    }

    override fun show(categoriesList: List<EventCategory>) {
        categoriesListAdapter.submitList(categoriesList)
        binding?.categoriesListRecyclerView?.layoutManager = LinearLayoutManager(context)
    }

    override fun error(e: Throwable) {
        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
    }

    override fun onEventClicked(category: EventCategory) {
        presenter.showEventsList(category)
    }

    companion object {

        fun newInstance() = CategoriesListFragment().apply {
            App.instance.applicationComponent.inject(this)
        }
    }
}