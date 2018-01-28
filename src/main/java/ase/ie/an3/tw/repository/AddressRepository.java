package ase.ie.an3.tw.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ase.ie.an3.tw.entity.Address;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

}