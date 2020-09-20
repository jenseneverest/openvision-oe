MODULES	= openvision
kmodule_test-y := openvision.o
obj-m += $(MODULES:%=%.o)
BUILD	= $(MODULES:%=%.ko)

default: all

all::
	$(MAKE) -C $(KERNEL_SOURCE) ARCH=$(ARCH) SUBDIRS=$(CURDIR) CC=${CC} modules

clean::
	rm -f $(BUILD) *.o *.ko *.mod.c *.mod.o *~ .*.cmd Module.symvers
	rm -rf .tmp_versions
