SECTION = "kernel/modules"
LICENSE = "CLOSED"
PRIORITY = "required"
MAINTAINER = "Open Vision Developers"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://openvision.c file://Makefile"

S = "${WORKDIR}"

inherit module machine_kernel_pr

EXTRA_OEMAKE = "KSRC=${STAGING_KERNEL_BUILDDIR}"

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake -C "${STAGING_KERNEL_BUILDDIR}" M="${S}" modules
}

do_compile_osmini4k() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake -C "${STAGING_KERNEL_DIR}" M="${S}" modules
}

do_compile_osmio4k() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake -C "${STAGING_KERNEL_DIR}" M="${S}" modules
}

do_compile_osmio4kplus() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake -C "${STAGING_KERNEL_DIR}" M="${S}" modules
}

do_install () {
    install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/openvision
    install -m 0644 ${S}/openvision.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/openvision
    install -d ${D}/${sysconfdir}/modules-load.d
    echo openvision >> ${D}/${sysconfdir}/modules-load.d/zzopenvision.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/zzopenvision.conf"
