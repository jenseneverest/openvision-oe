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

do_compile_dreamone() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake -C "${STAGING_KERNEL_DIR}" M="${S}" modules
}

do_configure[nostamp] = "1"

do_configure_prepend(){
    sed -i "s/@VISIONVERSION@-@VISIONREVISION@/${VISIONVERSION}-${VISIONREVISION}/" "${S}/openvision.c"
    sed -i "s/@MACHINE@/${MACHINE}/" "${S}/openvision.c"
    sed -i "s/@BOX_BRAND@/${BOX_BRAND}/" "${S}/openvision.c"
    sed -i "s/@VISIONLANGUAGE@/${VISIONLANGUAGE}/" "${S}/openvision.c"
    sed -i "s/@BUILD_VERSION@/${BUILD_VERSION}/" "${S}/openvision.c"
    sed -i "s/@PREFERRED_VERSION_python@/${PREFERRED_VERSION_python}/" "${S}/openvision.c"
    sed -i "s/@HAVE_MULTILIB@/${HAVE_MULTILIB}/" "${S}/openvision.c"
    sed -i "s/@DEFAULTTUNE@/${DEFAULTTUNE}/" "${S}/openvision.c"
    sed -i "s/@DEVELOPER_NAME@/${DEVELOPER_NAME}/" "${S}/openvision.c"
}

do_install () {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/openvision
    install -m 0644 ${S}/openvision.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/openvision
    install -d ${D}/${sysconfdir}/modules-load.d
    echo openvision >> ${D}/${sysconfdir}/modules-load.d/zzopenvision.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/zzopenvision.conf"
