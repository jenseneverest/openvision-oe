do_install_append() {
    sed -i 's#${bindir}/env python#${bindir}/env python2#g' ${D}${bindir}/scons*
}
