package ru.oliverhd.kudagoevents.categorieslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.Router
import dagger.android.support.AndroidSupportInjection
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.oliverhd.kudagoevents.databinding.FragmentCategoriesListBinding
import ru.oliverhd.kudagoevents.model.EventCategory
import ru.oliverhd.kudagoevents.repository.Repository
import ru.oliverhd.kudagoevents.scheduler.Schedulers
import javax.inject.Inject

class CategoriesListFragment : MvpAppCompatFragment(), CategoriesListView,
    CategoriesListAdapter.Delegate {

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var schedulers: Schedulers

    private val categoriesListAdapter = CategoriesListAdapter(delegate = this)

    @Inject
    lateinit var router: Router

    private val presenter: CategoriesListPresenter by moxyPresenter {
        CategoriesListPresenter(repository, router, schedulers)
    }

    private var binding: FragmentCategoriesListBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

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

    override fun onCategoryClicked(category: EventCategory) {
        presenter.showEventsList(category)
    }

    companion object {

        fun newInstance() = CategoriesListFragment()
    }
}