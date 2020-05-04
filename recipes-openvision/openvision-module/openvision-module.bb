SECTION = "kernel/modules"
LICENSE = "CLOSED"
PRIORITY = "required"

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = "ovlock"

SRC_URI = "file://openvision.c file://Makefile"

S = "${WORKDIR}"

inherit module machine_kernel_pr

EXTRA_OEMAKE = "KSRC=${STAGING_KERNEL_BUILDDIR}"

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake -C "${STAGING_KERNEL_BUILDDIR}" M="${S}" modules
}

do_install () {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/openvision
    install -m 0644 ${S}/openvision.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/openvision
    install -d ${D}/${sysconfdir}/modules-load.d
    echo openvision >> ${D}/${sysconfdir}/modules-load.d/zzopenvision.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/zzopenvision.conf"
