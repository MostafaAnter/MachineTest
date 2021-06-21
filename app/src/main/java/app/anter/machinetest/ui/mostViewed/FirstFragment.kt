package app.anter.machinetest.ui.mostViewed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import app.anter.machinetest.data.model.Result
import app.anter.machinetest.databinding.FragmentFirstBinding
import com.dashnan.klliq.core.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // init data for recyclerview
    private var mAdapter: MostViewdListAdapter? = null
    private val modelList = ArrayList<Result>()

    //init view model
     private val viewmodel: MostViewdViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set adapter
        setAdapter()

        //listen for comming data
        handleDataCommingFromServerSide()

        //request data
        viewmodel.getMostViewd()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setAdapter() {
        mAdapter = MostViewdListAdapter(requireActivity(), modelList)
        binding.recyclerView!!.setHasFixedSize(true)

        // use a linear layout manager
        val layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerView!!.layoutManager = layoutManager

        binding.recyclerView!!.adapter = mAdapter
        mAdapter!!.SetOnItemClickListener(object : MostViewdListAdapter.OnItemClickListener {
            override fun onItemClick(view: View?, position: Int, model: Result?) {

                //handle item click events here
                Toast.makeText(requireActivity(), "Hey " + model!!.title, Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun handleDataCommingFromServerSide(){
        lifecycleScope.launch {
            viewmodel.mostViewed_response.collect {
                when(it.status){
                    Status.LOADING->{
                        //do some staff here like show progress
                    }
                    Status.SUCCESS->{
                        //add data to adapter
                        mAdapter?.updateList(ArrayList(it.data!!.results!!))
                    }
                    Status.ERROR->{
                        // show error dialog to user
                    }
                }
            }
        }
    }
}